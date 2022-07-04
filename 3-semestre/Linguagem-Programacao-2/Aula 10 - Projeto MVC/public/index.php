<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="/assets/img/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="/assets/css/style.css">
        <title>Projeto MVC</title>
    </head>
    <body>
        <header>
            <div class="nav_logo">
                <img src="/assets/img/favicon.ico" alt="icon">
                <a href="/">
                    Projeto MVC
                </a> 
            </div>
            <nav>
                <ul>
                    <li><a href="/user/index">Usuários</a></li>
                    <li><a href="/project/index">Projetos</a></li>
                </ul>
            </nav>
        </header>
    <?php
        require '../Application/autoload.php';
        use Application\core\App;
        use Application\core\Controller;
        $app = new App();
    ?>
    <footer>
        <div class="content">
            <span>
                Instituto Federal Catarinense
                <br>
                Campus Videira.
            </span>
            <p>
                &copy; 2022 DevKong
            </p>
        </div>
        <div class="content">
            <h2>Midias sociais</h2>
            <div class="social">
                <a href="https://www.facebook.com/G.Amarilho/"><img src="/assets/img/facebook-icon.png" alt="facebook"></a>
                <a href="https://twitter.com/Gui_Amarilho"><img src="/assets/img/twitter-icon.png" alt="twitter"></a>
                <a href="https://www.instagram.com/gui_amarilho/"><img src="/assets/img/instagram-icon.png" alt="instagram"></a>
                <a href="https://github.com/GuilhermeAmarilho"><img src="/assets/img/github-icon.png" alt="github"></a>
                <a href="https://www.linkedin.com/in/amarilho"><img src="/assets/img/linkedin-icon.png" alt="linkedin"></a>
            </div>
        </div>
        <div class="content">
            <h2>Mapa do site</h2>
            <ul>
                <ul>
                    <li>Usuários</li>
                    <li><a href="/user/index">Listar</a></li>
                    <li><a href="/user/insert">Inserir</a></li>
                </ul>
                <ul>
                    <li>Projetos</li>
                    <li><a href="/project/index">Listar</a></li>
                    <li><a href="/project/insert">Inserir</a></li>
                </ul>
            </ul>
        </div>
    </footer>
    </body>
</html>
