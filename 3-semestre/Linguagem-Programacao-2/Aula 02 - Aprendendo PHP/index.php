<?php 
    
    // Imprimindo olá mundo

use function PHPSTORM_META\type;

echo "Olá Mundo!<br />";
    print('Olá Mundo!<br />');

    print_r('Olá Mundo!<br />');
    var_dump('Olá Mundo!');

    // --------------------------
    $nome = "Fabricio";
    $sobrenome = 'Bizotto';

    // Concatenar
    // CammelCase
    $nomeCompleto = $nome . " " . $sobrenome;
    // snake_case
    $nome_completo = $nome . " " . $sobrenome;
?>
<p style="background-color: deepskyblue">
    <?php echo $nomeCompleto, " - ", $nome_completo; ?>
</p>

<!-- Declaração de variáveis (string, int, real, array/vetor, hash) -->
<hr>

<?php 

    $nota1 = 8;
    $nota2 = 7;

    echo $nota1 + $nota2, '<br />';
    echo $nota1 - $nota2, '<br />';
    echo $nota1 * $nota2, '<br />';
    echo $nota1 / $nota2, '<br />';
    
    try {
        echo $nota1 / 0, '<br />';
    } catch (\DivisionByZeroError $th) {
        //throw $th;
        echo "Não pode dividir por zero!<br />";
    }

    echo $nota1 ** $nota2, '<br />';
    echo $nota1 % $nota2, '<br />';
?>

<hr>
<?php 
// real, array/vetor, hash

    $n1 = 5.5;
    $n2 = 2.5465;

    var_dump($n1 + $n2);
?>
<hr>
<?php 
    // Array/vetor - JAVA
    // String cores = new String[] {"azul", "verde", "rosa"};

    // Array/vetor - PHP
    $cores = [ 'azul', 'verde', 5, ['rosa', 'vermelho'] ];

    print_r($cores);
    echo '<br />';
    echo $cores[1];
    echo '<br />';
    echo sizeof($cores);
    echo '<br />';
    echo count($cores);
?>
<hr>
<?php 

    // for, foreach, while
    for($i=0; $i < sizeof($cores); $i++){
        $type = gettype($cores[$i]);
        
        if ($type == 'array') {
            foreach ($cores[$i] as $chave => $valor) {
                echo $chave;
                echo ' - ';
                print_r($valor);
                echo ' - ';
                echo gettype($valor);
                echo '<br />';
            }
        } else {
            echo $i;
            echo ' - ';
            print_r($cores[$i]);
            echo ' - ';
            echo gettype($cores[$i]);
            echo '<br />';
        }
        

       
    }
?>