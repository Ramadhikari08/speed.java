<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Typing Speed Test</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        padding: 40px;
        text-align: center;
    }
    h1 { color: #333; }

    #test-area {
        width: 60%;
        margin: 20px auto;
        padding: 20px;
        background: white;
        border-radius: 10px;
        box-shadow: 0 0 10px #ccc;
    }
    #quote {
        font-size: 20px;
        margin-bottom: 20px;
        background: #eee;
        padding: 15px;
        border-radius: 8px;
    }
    #inputArea {
        width: 100%;
        padding: 10px;
        font-size: 18px;
        border: 2px solid #888;
        border-radius: 6px;
    }
    #inputArea:focus {
        outline: none;
        border-color: #3498db;
    }
    #result {
        margin-top: 25px;
        font-size: 18px;
        color: #444;
    }
    button {
        padding: 12px 20px;
        margin-top: 15px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        background: #3498db;
        color: white;
        cursor: pointer;
    }
    button:hover {
        background: #2980b9;
    }
</style>
</head>
<body>

<h1>Typing Speed Test</h1>

<div id="test-area">
    <div id="quote">Click "Start" to begin the test.</div>
    <textarea id="inputArea" placeholder="Start typing here..." disabled></textarea>
    
    <button onclick="startTest()">Start</button>

    <div id="result"></div>
</div>

<script>
    const quotes = [
        "JavaScript is the language of the web.",
        "Typing speed test helps improve your accuracy.",
        "Practice daily to become a faster typist.",
        "Coding is fun when you understand the basics."
    ];

    let startTime, endTime, originalText;

    function startTest() {
        originalText = quotes[Math.floor(Math.random() * quotes.length)];
        document.getElementById("quote").innerText = originalText;
        document.getElementById("inputArea").disabled = false;
        document.getElementById("inputArea").value = "";
        document.getElementById("inputArea").focus();

        startTime = new Date().getTime();
        document.getElementById("result").innerHTML = "";

        document.getElementById("inputArea").addEventListener("input", checkTyping);
    }

    function checkTyping() {
        let typedText = document.getElementById("inputArea").value;

        if (typedText === originalText) {
            endTime = new Date().getTime();
            let timeTaken = (endTime - startTime) / 1000; // seconds

            let wordCount = originalText.split(" ").length;
            let wpm = Math.round((wordCount / timeTaken) * 60);

            let accuracy = calculateAccuracy(originalText, typedText);

            document.getElementById("result").innerHTML =
                `<b>Time:</b> ${timeTaken.toFixed(2)} sec<br>
                 <b>Words per Minute (WPM):</b> ${wpm}<br>
                 <b>Accuracy:</b> ${accuracy}%`;

            document.getElementById("inputArea").disabled = true;
        }
    }

    function calculateAccuracy(original, typed) {
        let correct = 0;
        for (let i = 0; i < typed.length; i++) {
            if (typed[i] === original[i]) correct++;
        }
        return Math.round((correct / original.length) * 100);
    }
</script>

</body>
</html>
