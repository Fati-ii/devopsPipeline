<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Médailles Olympiques - Accueil</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --bg-gradient: linear-gradient(135deg, #0f172a, #1e293b);
            --glass-bg: rgba(255, 255, 255, 0.05);
            --glass-border: rgba(255, 255, 255, 0.1);
        }
        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
            background: var(--bg-gradient);
            color: #fff;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }
        .container {
            text-align: center;
            background: var(--glass-bg);
            backdrop-filter: blur(15px);
            border: 1px solid var(--glass-border);
            border-radius: 24px;
            padding: 60px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
            animation: fadeIn 1s ease-out;
            position: relative;
            z-index: 10;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: scale(0.95); }
            to { opacity: 1; transform: scale(1); }
        }
        h1 {
            font-size: 3.5rem;
            margin-bottom: 20px;
            background: linear-gradient(to right, #fbbf24, #f59e0b);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        p {
            font-size: 1.2rem;
            color: #cbd5e1;
            margin-bottom: 40px;
        }
        .btn {
            display: inline-block;
            background: linear-gradient(135deg, #fbbf24, #d97706);
            color: #fff;
            padding: 15px 35px;
            border-radius: 50px;
            text-decoration: none;
            font-weight: 600;
            font-size: 1.1rem;
            transition: all 0.3s ease;
            box-shadow: 0 10px 15px -3px rgba(251, 191, 36, 0.3);
        }
        .btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 20px 25px -5px rgba(251, 191, 36, 0.4);
        }
        .circles {
            position: absolute;
            top: 0; left: 0; width: 100%; height: 100%;
            overflow: hidden; z-index: 1; pointer-events: none;
        }
        .circle {
            position: absolute;
            border-radius: 50%;
            background: radial-gradient(circle, rgba(251,191,36,0.15) 0%, rgba(251,191,36,0) 70%);
        }
        .c1 { width: 600px; height: 600px; top: -200px; left: -200px; }
        .c2 { width: 400px; height: 400px; bottom: -100px; right: -100px; }
    </style>
</head>
<body>
    <div class="circles">
        <div class="circle c1"></div>
        <div class="circle c2"></div>
    </div>
    <div class="container">
        <h1>Système de Suivi des Médailles Olympiques</h1>
        <p>Gérez et consultez les classements en temps réel avec une interface premium.</p>
        <a href="/tableau-medailles" class="btn">Voir le Classement</a>
    </div>
</body>
</html>
