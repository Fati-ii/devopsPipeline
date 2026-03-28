<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Tableau des Médailles</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --bg-gradient: linear-gradient(135deg, #020617, #0f172a);
            --glass-bg: rgba(255, 255, 255, 0.05);
            --glass-border: rgba(255, 255, 255, 0.1);
            --gold: #fbbf24;
            --silver: #94a3b8;
            --bronze: #b45309;
        }
        body {
            margin: 0;
            font-family: 'Inter', sans-serif;
            background: var(--bg-gradient);
            color: #f8fafc;
            min-height: 100vh;
            padding: 40px 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .header {
            text-align: center;
            margin-bottom: 40px;
            animation: slideDown 0.8s ease-out;
        }
        @keyframes slideDown {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .header h1 {
            font-size: 2.8rem;
            background: linear-gradient(to right, #fbbf24, #f59e0b);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-bottom: 5px;
        }
        .container {
            width: 100%;
            max-width: 900px;
            background: var(--glass-bg);
            backdrop-filter: blur(12px);
            border: 1px solid var(--glass-border);
            border-radius: 20px;
            padding: 30px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
            animation: fadeIn 1s ease-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
        }
        th {
            text-align: left;
            padding: 15px 20px;
            color: #94a3b8;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-size: 0.85rem;
        }
        td {
            padding: 15px 20px;
            background: rgba(255, 255, 255, 0.03);
            transition: transform 0.2s, background 0.2s;
        }
        tr td:first-child { border-top-left-radius: 12px; border-bottom-left-radius: 12px; }
        tr td:last-child { border-top-right-radius: 12px; border-bottom-right-radius: 12px; }
        
        tbody tr { cursor: pointer; }
        tbody tr:hover td {
            background: rgba(255, 255, 255, 0.08);
            transform: scale(1.01);
        }
        .rank { font-weight: 800; font-size: 1.2rem; color: #cbd5e1; }
        .country { display: flex; align-items: center; gap: 15px; font-weight: 600; font-size: 1.1rem; }
        .medal { font-weight: 800; font-size: 1.1rem; text-align: center; }
        .gold { color: var(--gold); }
        .silver { color: var(--silver); }
        .bronze { color: var(--bronze); }
        .total { font-weight: 800; color: #fff; text-align: center;}
        
        .back-btn {
            display: inline-block;
            margin-top: 30px;
            color: #fbbf24;
            text-decoration: none;
            font-weight: 600;
            transition: color 0.3s;
        }
        .back-btn:hover { color: #f59e0b; }
    </style>
</head>
<body>
    <div class="header">
        <h1>Jeux Olympiques 2026</h1>
        <p>Classement Officiel en Temps Réel</p>
    </div>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Rang</th>
                    <th>Délégation</th>
                    <th style="text-align:center;"> Or</th>
                    <th style="text-align:center;"> Argent</th>
                    <th style="text-align:center;"> Bronze</th>
                    <th style="text-align:center;">Total</th>
                    <th style="text-align:center;">Points</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pays" items="${classement}" varStatus="status">
                    <tr>
                        <td class="rank">#${status.index + 1}</td>
                        <td class="country">
                            <span>${pays.codePays}</span>
                            ${pays.nomPays}
                        </td>
                        <td class="medal gold">${pays.orCount}</td>
                        <td class="medal silver">${pays.argentCount}</td>
                        <td class="medal bronze">${pays.bronzeCount}</td>
                        <td class="total">${pays.total}</td>
                        <td class="total" style="color:#10b981;">${pays.points} pts</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <a href="/" class="back-btn">← Retour à l'accueil</a>
    </div>
</body>
</html>
