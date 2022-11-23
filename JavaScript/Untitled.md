```java
{
                    //TODO read message

                    // 1. get the input stream from the socket
                    //  2. Turn the data input stream into a Data input stream. Data input stream is just like a scanner. It wraps the normal inputStream

                    DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                    //a. read first 2 bytes and parse those bytes for masks, Opcode, and length
                    byte [] ArrayFirstTwoBytes = new byte[2];
                    dataInputStream.readNBytes(ArrayFirstTwoBytes,0,2);
                    for ( int i = 0; i< ArrayFirstTwoBytes.length; i++ ){
                        System.out.println("byte is " + ArrayFirstTwoBytes[i]);
                    }
                    System.out.println("ArrayFirstTwoBytes are: " + Arrays.toString(ArrayFirstTwoBytes));

                    boolean Fin = (ArrayFirstTwoBytes[0] & 0x80) != 0; // fin ==1, this is the only packed in this msg
                    if ( Fin ){
                        System.out.println("this is the only packet in this msg / the  final text");
                    }

                    byte Opcode = (byte) (ArrayFirstTwoBytes [0] & 0x0F);
                    if (Opcode == 0x1){
                        System.out.println("the data is a text");
                    } else if (Opcode == 0x2) {
                        System.out.println(" data is a binary");
                    } else if ( Opcode == 0x8) {
                        System.out.println(" This is the close frame");

                    }

                    // mask
                    boolean isMasked = (ArrayFirstTwoBytes[1] & 0x80) != 0; // masked = 1, it is masked.
                    if (isMasked){
                        System.out.println("It is masked");
                    }
                    //payload length
                    int lengthGuess = ArrayFirstTwoBytes[1] & 0x7F; // get rid of the masking bit
                    int payloadLength;
                    if (lengthGuess <= 125 ){
                        payloadLength = lengthGuess;
                        System.out.println("The length that was sent to us is " + payloadLength );
                    }else if(lengthGuess == 126 ){
                        // read in the next 2 bytes which is equivalent to a short
                        payloadLength = (int)dataInputStream.readShort();
                        System.out.println("The length that was sent to us is " + payloadLength );
                    } else {
                        // if length guess => 127, read in the long
                        payloadLength = (int) dataInputStream.readLong();
                        System.out.println("The payload length is: " + payloadLength );
                    }

                    // masking key, if it is masked, read in 4 bytes
                    byte[] maskingKey = null;
                    if ( isMasked) {
                        maskingKey = new byte[4];
                        dataInputStream.readNBytes(maskingKey, 0, 4);
                    }
                    System.out.println("maskingKey is: " + Arrays.toString(maskingKey));

                    // TODO fix the decoding formula and print the payload itself
                    // payload itself
                    byte[] payload = new byte[payloadLength];
                    dataInputStream.readNBytes(payload, 0, payloadLength);
                    System.out.println("payload is : " + Arrays.toString(payload));

                    // decode the masking key
                    byte[] Decoded = new byte[payloadLength];
                    if(isMasked) {
                        for( int i=0; i< payloadLength; i++ ) {
                            Decoded[i] = ((byte) (payload[i] ^ maskingKey[i%4]));
                        }
                    }
                    // TODO validation for Decoded message
                    String decodeString = new String(Decoded);

                    System.out.println("Decoded is: " + decodeString);

                    // TODO handle the closing when a client leaves the room


                    // TODO Respond message
                    DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                    String message = "";

                    byte[] rawData =  message.getBytes();
                    byte[] frame = new byte[10];
                    int indexStartRawData = 0;
                    int length = rawData.length;

                    frame[0] = (byte) 129; // first byte

                    if(length <= 125 ) {
                        frame[1] = (byte) length;
                        indexStartRawData = 2;
                    }else if (length >= 126 && length <= 65535) {
                        frame[1] = (byte) 126;
                        frame[2] = (byte) ((length >> 8) & (byte)255);
                        frame[3] = (byte) (length & (byte) 255);
                        indexStartRawData = 4;
                    } else{
                        frame[1] = (byte)127;
                        frame[2] = (byte)((length >> 56 ) & (byte)255);
                        frame[3] = (byte)((length >> 48 ) & (byte)255);
                        frame[4] = (byte)((length >> 40 ) & (byte)255);
                        frame[5] = (byte)((length >> 32 ) & (byte)255);
                        frame[6] = (byte)((length >> 24 ) & (byte)255);
                        frame[7] = (byte)((length >> 16 ) & (byte)255);
                        frame[8] = (byte)((length >> 8 ) & (byte)255);
                        frame[9] = (byte)(length & (byte)255);
                        indexStartRawData = 10;
                    }

                    int responseLength = indexStartRawData + length;
                    byte[] OutPutResponse = new byte[responseLength];

                    // copy the frame bytes into the response
                    int Index = 0;
                    for ( int i=0; i<indexStartRawData; i++) {
                        OutPutResponse[Index] = frame[i];
                        Index ++;
                    }
                    // copy the raw data into the reply
                    for ( int i=0; i < rawData.length; i++ ) {
                        OutPutResponse[Index] = rawData[i];
                        Index ++;
                    }

                    dataOutputStream.write(OutPutResponse);
                    dataOutputStream.flush();
                    System.out.println("test1");


                }
```

