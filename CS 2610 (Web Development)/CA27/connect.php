<?php
    $connect = new mysqli("localhost","cs2610","owl","cs2610");
    
    if($connect->connect_error) {
        die("<h2>Failed to connect to the database:<br/>$connect->connect_error</h2>");
     }
?>