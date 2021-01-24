# OnlineBookingStadium

1.https://github.com/Vivien87/OnlineBookingStadium : clone and open project OnlineBookingStadium<br>
2.run server BookingApplication <br>
3.list api: <br>
(GET)http://localhost:8082/api/v1/customers : get list customers  <br>
(GET)http://localhost:8082/api/v1/price/all : fet list of all prices with types of sectors <br>
(GET)http://localhost:8082/api/v1/sectors/{id} : get sector by id <br>
(GET)http://localhost:8082/api/v1/sectors : get all sectors <br>
(GET)http://localhost:8082/api/v1/sectors/available : get all free seats <br>
(GET)http://localhost:8082/api/v1/sectors/{id}/available : check for free sector with seat by id <br>
(GET)http://localhost:8082/api/v1/sectors/types : get list of sector types <br>
(POST)http://localhost:8082/api/v1/stadium/booking : booking seat by sectorId or sectorId,seatNumber,rowNumber <br>

http://localhost:8082/h2-console : db <br>
username:sa   <br>
password: empty  <br>