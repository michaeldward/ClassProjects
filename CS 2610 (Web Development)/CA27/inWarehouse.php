<?php
$result = $connect->query("SELECT id, name FROM warehouse");
                ?>
                <?php 
                echo "<pre>";
                print_r($_POST);
                echo "</pre>";
            ?>
            <?php
        if(isset($_POST['list'])) {
            $query = "SELECT item.partno, quantity, description FROM instock JOIN item ON instock.partno = item.partno WHERE warehouseId = $_POST[warehouse]";
            $result2 = $connect->query($query);
            $warehouse = $connect->query("SELECT name FROM warehouse WHERE id=$_POST[warehouse]");
            $warehouse = $warehouse->fetch_assoc();
            echo("<h2>Current Inventory at $warehouse[name]</h2>");
            echo("<table><tr><th>Part Number</th><th>Quantity</th><th>Description</th></tr>");
            while($row = $result2->fetch_assoc()) {
                echo "<tr><td>$row[partno]</td><td>$row[quantity]</td><td>$row[description]</td></tr>";
            }
            echo("</table>");
        }
        ?>
        <h2>Select The Warehouse From the List Below<br/>And Click the List Parts Button</h2>
        <p><label for="warehouse">Warehouse</label>
            <select id="warehouse" name="warehouse" />
            
            <?php
            while($row = $result->fetch_assoc()) {
                echo "<option value='$row[id]'>$row[name]</option>";
            }
            ?>
            </select>
        </p>            
        <p><input type="submit" id="list" name="list" value="List Parts" /></p>
        