<?php
    $connect = new mysqli("localhost","xenophon","kingsyphax","xenophon");
    
    if($connect->connect_error) {
        die("<h2>Failed to connect to the database:<br/>$connect->connect_error</h2>");
     }
?>