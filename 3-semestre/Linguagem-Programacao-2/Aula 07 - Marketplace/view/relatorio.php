<?php
    require("index.html");
    // print_r($_COOKIE);
    $totalCliques = $_COOKIE['celular'] + $_COOKIE['eletrodomestico'] + $_COOKIE['periferico'] + $_COOKIE['roupa'];
    $date = new DateTime("now", new DateTimeZone('America/Sao_Paulo') );
?>

<div class="container">
	<table>
		<thead>
			<tr>
				<th>Categoria</th>
				<th>Cliques</th>
				<th>% de cliques</th>
				<th>Ultima visita</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Geral</td>
				<td><?php echo $totalCliques; ?></td>
				<td>100%</td>
				<td>Não aplicavel</td>
			</tr>
			<tr>
				<td>Eletrodomesticos</td>
				<td><?php echo $_COOKIE['eletrodomestico']; ?></td>
				<td><?php echo ($_COOKIE['eletrodomestico']/$totalCliques)*100; ?>%</td>
				<td><?php echo $_COOKIE['dataeletrodomestico']; ?></td>
			</tr>
			<tr>
				<td>Roupas</td>
				<td><?php echo $_COOKIE['roupa']; ?></td>
				<td><?php echo ($_COOKIE['roupa']/$totalCliques)*100; ?>%</td>
				<td><?php echo $_COOKIE['dataroupa']; ?></td>
			</tr>
			<tr>
				<td>Celulares</td>
				<td><?php echo $_COOKIE['celular']; ?></td>
				<td><?php echo ($_COOKIE['celular']/$totalCliques)*100; ?>%</td>
				<td><?php echo $_COOKIE['datacelular']; ?></td>
			</tr>
			<tr>
				<td>Periféricos</td>
				<td><?php echo $_COOKIE['periferico']; ?></td>
				<td><?php echo ($_COOKIE['periferico']/$totalCliques)*100; ?>%</td>
				<td><?php echo $_COOKIE['dataperiferico']; ?></td>
			</tr>
		</tbody>
	</table>
</div>


<?php
    require("footer.html");
?>