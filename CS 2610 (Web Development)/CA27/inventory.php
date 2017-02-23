<?php
    include 'head.html';
    include 'connect.php';
    if(isset($_POST['addItem']) || isset($_POST['add'])) {
        include 'addItem.php';
    } 
    if(isset($_POST['add'])) {
        include 'add.php';
    }
    if(isset($_POST['inWarehouse']) || isset($_POST['list'])) {
        include 'inWarehouse.php';
    }
    if(isset($_POST['allItems'])) {
        include 'allItems.php';
    }
?>

    </form>
    </div>
    </body>
</html>