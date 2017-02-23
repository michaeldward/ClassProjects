<?php
        $result = $connect->query("SELECT DISTINCT category FROM item");
        //$query = "SELECT name, item.partno, description, quantity FROM warehouse JOIN instock ON instock.partno=item.partno WHERE id=$_POST[warehouse]";
        ?>
    <h2>Add A New Item To Inventory</h2>
    <p><label for="partNo">Part Number</label><input id="partNo" type="text" name="partNo" /></p>
    <p><label for="description">Description</label><input id="description" type="text" name="description" /></p>
    <p><label for="category">Category</label>
        <select id="category" name="category">
            <?php
            while($row = $result->fetch_assoc()) {
                echo "<option value='$row[category]'>$row[category]</option>";
            }
            ?>
        </select>
    </p>
    <p><input type="submit" id="add" name="add" value="Add Item" /></p>