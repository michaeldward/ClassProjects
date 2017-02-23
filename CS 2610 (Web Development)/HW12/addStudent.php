<?php
    /*echo "<pre>";
    print_r($_POST);
    echo "</pre>"; */
    //adding a new student to the database:
    $added = "";
    $firstName = "";
    $lastName = "";
    $phone = "";
    $major = "";
    $firstNameError = "";
    $lastNameError = "";
    $phoneError = "";
    $majorError = "";
    if(isset($_POST['addStudent'])) {
        if(empty($_POST['firstName'])) {
            $firstNameError = "Please enter a valid first name.";
        }
        else {
            $firstName = $connect->real_escape_string(htmlentities($_POST['firstName']));
        }
        if(empty($_POST['lastName'])) {
            $lastNameError = "Please enter a valid last name.";
        }
        else {
            $lastName = $connect->real_escape_string(htmlentities($_POST['lastName']));
        }
        $phoneRegExp = "~\b([2-9]\d\d)?[-. ]?[2-9]\d\d[-. ]?\d{4}\b~";
        $phone = $connect->real_escape_string(htmlentities($_POST['phone']));
        $phoneMatch = preg_match($phoneRegExp, $phone);
        if(!$phoneMatch) {
            $phoneError = "Please enter a valid phone number.";
        }
        if(empty($_POST['major'])) {
            $majorError = "Please enter a valid major.";
        }
        else {
            $major = $connect->real_escape_string(htmlentities($_POST['major']));
        }
        $query = "INSERT INTO students(firstName, lastName, phone, major) VALUES ('$firstName', '$lastName', '$phone', '$major')";
        if($firstNameError == "" && $lastNameError == "" && $phoneError == "" && $majorError == "") {
            $worked = $connect->query($query);
            if($worked) {
                $added = "$firstName $lastName added!";
                $firstName = "";
                $lastName = "";
                $phone = "";
                $major = "";
            }
            else {
                $added = "An error occurred. Please contact the system administrator.";
            }
        }
        else {
            $added = "";
        }
    }
?>
<h2>Student Information</h2>
<p><label for="firstName">First Name</label><input id="firstName" type="text" name="firstName" value="<?php echo($firstName); ?>"/><span class="error"><?php echo($firstNameError); ?></span></p>
<p><label for="lastName">Last Name</label><input id="lastName" type="text" name="lastName" value="<?php echo($lastName);?>"/><span class="error" ><?php echo($lastNameError); ?></span></p>
<p><label for="phone">Phone Number</label><input id="phone" type="text" name="phone" value="<?php echo($phone);?>"/><span class="error" ><?php echo($phoneError); ?></span></p>
<p><label for="major">Major</label><input id="major" type="text" name="major" value="<?php echo($major);?>"/><span class="error"><?php echo($majorError); ?></span></p>

<p><input type="submit" id="addStudent" name="addStudent" value="Add Student" /></p>
<p><?php echo($added); ?></p>