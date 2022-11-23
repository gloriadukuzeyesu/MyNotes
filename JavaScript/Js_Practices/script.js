"use strict";

let today = new Date();
let hourNow = today.getHours;
// console.log(hourNow);
let greetings;

if ( hourNow > 18 ) {
    greetings = "Good evening";
}else if( hourNow > 12 ){
    greetings = "Good afternoon";
}else if ( hourNow > 0) {
    greetings = " Good Morning";
}else{
    greetings = "welcome";
}

document.write(greetings); 

let hours = today.getFullYear;
document.write(today);

document.write(hours); 


let hotel = new Object();
hotel.name = "Gloria Hotel";
hotel.rooms = 24;
hotel.booked = 10;
hotel.checkAvailability = function () {
    return this.rooms - this.booked;
}
document.writeln(hotel.name);
document.write(hotel.checkAvailability());

console.log(hotel.name);

function Hotel (name, rooms, booked) {
    this.name = name;
    this.rooms = rooms;
    this.booked = booked;
    this.checkAvailability = function () {
        return this.rooms - this.booked;
    }
}

let hotel1 = new Hotel ("Park", 45, 10);
let hotel2 = new Hotel ("City", 95, 10);


let detailsS1 = hotel1.name + "rooms: ";
detailsS1 += hotel1.checkAvailability();
console.log(detailsS1);

let detailsS2 = hotel2.name + "rooms: ";
detailsS2 += hotel2.checkAvailability();
console.log(detailsS2);



