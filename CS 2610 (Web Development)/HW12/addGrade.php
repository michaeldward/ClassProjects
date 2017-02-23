<?php
//$result = $connect->query("SELECT firstName, lastName FROM students ORDER BY lastName");
                ?>
                <?php 
                echo "<pre>";
                print_r($_POST);
                echo "</pre>";
            ?>
        <?php
        if(isset($_POST['list'])) {
            $query = "SELECT id, firstName, lastName, grade FROM students LEFT JOIN grades ON students.id = studentId ORDER BY lastName";
            $result = $connect->query($query);
            while($row = $result->fetch_assoc()) {
                echo "<label for=\"$row[id]\">$row[firstName] $row[lastName]</label><input id=\"$row[id]\" name=\"$row[id]\" value=\"$row[grade]\"><br>";
            }
            echo("<p><input type=\"submit\" id=\"addGrade\" name=\"addGrade\" value=\"Add Grade\" /></p>");
        }
        ?>
        <h2>Select The Assignment From the List Below<br/>And Click the List Grades Button</h2>
        <p><label for="assignment">Assignment</label>
            <select id="assignment" name="assignment" />
            <?php
            $query2 = "SELECT name, id FROM assignments";
            $result2 = $connect->query($query2);
            while($row = $result2->fetch_assoc()) {
                echo "<option value='$row[id]'>$row[name]</option>";
            }
            echo("</select>");
            ?>
            </select>
        </p>            
        <p><input type="submit" id="list" name="list" value="List Grades" /></p>
        