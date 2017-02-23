<?php 
    /*echo "<pre>";
    print_r($_POST);
    echo "</pre>";*/
    //adding a new assignment to the database:
    $added = "";
    $nameError = "";
    $pointsError = "";
    $name = "";
    $maxPoints = "";
    if(isset($_POST['addAssignment'])) {
        if(empty($_POST['name'])) {
            $nameError = "Please enter a valid name.";
        }
        else {
            $name = $connect->real_escape_string(htmlentities($_POST['name']));
        }
        if(empty($_POST['maxPoints']) || $_POST['maxPoints'] < 1) {
            $pointsError = "Please enter a valid maximum points.";
        }
        else {
            $maxPoints = $connect->real_escape_string(htmlentities($_POST['maxPoints']));
        }
        $query = "INSERT INTO assignments(name, maxPoints, category) VALUES ('$name', '$maxPoints', '$_POST[category]')";
        if($nameError == "" && $pointsError == "") {
            $worked = $connect->query($query);
            if($worked) {
                $added = "$name added!";
                $name = "";
                $maxPoints = "";
            }
            else {
                $added = "An error occurred. Please contact the system administrator.";
            }
        } else {
            $added = "";
        }
    }
?>
<h2>Assignment Information</h2>
<p><label for="name">Name</label><input id="name" type="text" name="name" value="<?php echo($name);?>"/><span class="error"><?php echo($nameError);?></span></p>
<p><label for="maxPoints">Maximum Score</label><input id="maxPoints" type="text" name="maxPoints" value="<?php echo($maxPoints);?>" /><span class="error"><?php echo($pointsError);?></span></p>
<p><label for="category">Category</label>
    <select id="category" name="category">
    <option value = "HW">Homework</option>
    <option value = "Quiz">Quiz</option>
    <option value = "Exam">Exams</option>
    </select>
</p>
<p><input type="submit" id="addAssignment" name="addAssignment" value="Add Assignment" /></p>
<p><?php echo($added); ?></p>