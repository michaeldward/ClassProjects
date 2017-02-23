<?php
    include 'head.html';
    include 'connect.php';
    if(isset($_POST['newStudent']) || isset($_POST['addStudent'])) {
        include 'addStudent.php';
    } 
    if(isset($_POST['newAssignment']) || isset($_POST['addAssignment'])) {
        include 'addAssignment.php';
    }
    if(isset($_POST['newGrade']) || isset($_POST['list'])) {
        include 'addGrade.php';
    }
    /*
    if(isset($_POST['viewScores'])) {
        include 'viewScores.php';
    }
    */
?>

    </form>
    </div>
    </body>
</html>