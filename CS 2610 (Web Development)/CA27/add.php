<?php
    $partNum = $connect->real_escape_string(htmlentities($_POST['partNo']));
    $category = $connect->real_escape_string(htmlentities($_POST['category']));
    $description = $connect->real_escape_string(htmlentities($_POST['description']));
    $query = "INSERT INTO item VALUES ($partNum, '$description', '$category')";
    $worked = $connect->query($query);
    if($worked) {
        echo("Item added!");
    }
    else {
        echo("ERROR");
    }
?>