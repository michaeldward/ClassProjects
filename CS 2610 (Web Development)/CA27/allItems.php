<h2>Inventory</h2>
            <table>
                <tr><th>Part Number</th><th>Description</th><th>Warehouse</th><th>Quantity</th></tr>
           
            <?php
            $query = "SELECT instock.partno, item.description, warehouse.name, instock.quantity FROM item JOIN instock ON item.partno = instock.partno JOIN warehouse ON warehouse.id = instock.warehouseId";
		    $worked = $connect->query($query);
		    while($row = $worked->fetch_assoc()) {
                echo("<tr><td>$row[partno]</td><td>$row[description]</td><td>$row[name]</td><td>$row[quantity]</td></tr>");
            }
            ?>
             </table>
