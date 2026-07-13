<!DOCTYPE html>

<html lang="pt-BR">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Cross Road</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<div id="hud">

    <h2>Cross Road</h2>

    <div id="info">

        <span>Pontos:

            <strong id="score">0</strong>

        </span>

        <span>Vidas:

            <strong id="lives">3</strong>

        </span>

        <span>Fa
        *{

    margin:0;

    padding:0;

    box-sizing:border-box;

    font-family:Arial, Helvetica, sans-serif;

}

body{

    background:#1d1d1d;

    color:white;

    display:flex;

    flex-direction:column;

    align-items:center;

    justify-content:center;

    min-height:100vh;

}

#hud{

    width:600px;

    margin-bottom:15px;

}

#hud h2{

    text-align:center;

    margin-bottom:10px;

    letter-spacing:2px;

}

#info{

    display:flex;

    justify-content:space-between;

    background:#2b2b2b;

    padding:10px;

    border-radius:10px;

}

canvas{

    background:#4CAF50;

    border:5px solid white;

    border-radius:10px;

}

#mobile{

    display:none;

    margin-top:20px;

}

#mobile button{

    width:70px;

    height:70px;

    margin:5px;

    border:none;

    border-radius:12px;

    font-size:30px;

    background:#3b82f6;

    color:white;

}

#mobile button:active{

    transform:scale(.95);

}

@media(max-width:700px){

canvas{

    width:95vw;

    height:auto;

}

#hud{

    width:95vw;

}

#info{

    font-size:14px;

}

#mobile{

    display:flex;

    flex-direction:column;

    align-items:center;
    const canvas = document.getElementById("game");

const ctx = canvas.getContext("2d");

const scoreText = document.getElementById("score");

const livesText = document.getElementById("lives");

const levelText = document.getElementById("level");

const WIDTH = canvas.width;

const HEIGHT = canvas.height;

let score = 0;

let lives = 3;

let level = 1;

const player = {

    x: WIDTH / 2 - 20,

    y: HEIGHT - 50,

    width: 40,

    height: 40,

    speed: 40,

    color: "#00ff55"

};

const road = [

    120,

    180,

    240,

    300,

    360,

    420,

    480

];

const cars = [];

function createCars(){

    cars.length = 0;

    road.forEach((lane,index)=>{

        for(let i=0;i<3;i++){

            cars.push({

                x:i*230,

                y:lane,

                width:70,

                height:35,

                speed:(2+Math.random()*2)+(level*0.4),

                direction:index%2===0?1:-1,

                color:`hsl(${Math.random()*360},80%,55%)`

            });

        }

    });

}

createCars();

function resetPlayer(){

    player.x = WIDTH/2-20;

    player.y = HEIGHT-50;

}

document.addEventListener("keydown",(e)=>{

    switch(e.key){

        case "ArrowLeft":

            player.x -= player.speed;

            break;

        case "ArrowRight":

            player.x += player.speed;

            break;

        case "ArrowUp":

            player.y -= player.speed;

            break;

        case "ArrowDown":

            player.y += player.speed;

            break;
            

    }

});

}

}
function drawRoad(){

    ctx.fillStyle = "#3fa34d";

    ctx.fillRect(0,0,WIDTH,HEIGHT);

    road.forEach((lane)=>{

        ctx.fillStyle="#4a4a4a";

        ctx.fillRect(0,lane-5,WIDTH,50);

        ctx.strokeStyle="white";

        ctx.lineWidth=2;

        for(let i=0;i<WIDTH;i+=40){

            ctx.beginPath();

            ctx.moveTo(i,lane+20);

            ctx.lineTo(i+20,lane+20);

            ctx.stroke();

        }

    });

    ctx.fillStyle="#7ed957";

    ctx.fillRect(0,0,WIDTH,70);

    ctx.fillRect(0,HEIGHT-70,WIDTH,70);

}

function drawPlayer(){

    ctx.fillStyle=player.color;

    ctx.beginPath();

    ctx.arc(

        player.x+player.width/2,

        player.y+player.height/2,

        player.width/2,

        0,

        Math.PI*2

    );

    ctx.fill();

}

function drawCars(){

    cars.forEach(car=>{

        ctx.fillStyle=car.color;

        ctx.fillRect(

            car.x,

            car.y,

            car.width,

            car.height

        );

        ctx.fillStyle="#87CEEB";

        ctx.fillRect(car.x+10,car.y+7,18,12);

        ctx.fillRect(car.x+42,car.y+7,18,12);

    });

}

function updateCars(){

    cars.forEach(car=>{

        car.x += car.speed * car.direction;

        if(car.direction>0 && car.x>WIDTH+80){

            car.x=-100;

        }

        if(car.direction<0 && car.x<-100){

            car.x=WIDTH+80;

        }

    });

}

function collision(){

    for(const car of cars){

        if(

            player.x < car.x + car.width &&

            player.x + player.width > car.x &&

            player.y < car.y + car.height &&

            player.y + player.height > car.y

        ){

            lives--;

            livesText.textContent=lives;

            resetPlayer();

            if(lives<=0){

                alert("Game Over!");

                score=0;

                level=1;

                lives=3;

                scoreText.textContent=score;

                levelText.textContent=level;

                livesText.textContent=lives;

                createCars();

            }

            break;

        }
        function updateGame(){

    if(player.x < 0) player.x = 0;

    if(player.x + player.width > WIDTH)

        player.x = WIDTH - player.width;

    if(player.y + player.height > HEIGHT)

        player.y = HEIGHT - player.height;

    if(player.y <= 20){

        score += 100;

        level++;

        scoreText.textContent = score;

        levelText.textContent = level;

        createCars();

        resetPlayer();

    }

}

function drawHUD(){

    ctx.fillStyle = "rgba(0,0,0,.25)";

    ctx.fillRect(10,10,170,35);

    ctx.fillStyle = "white";

    ctx.font = "18px Arial";

    ctx.fillText("Objetivo: chegar ao topo",20,33);

}

function game(){

    ctx.clearRect(0,0,WIDTH,HEIGHT);

    drawRoad();

    updateCars();

    collision();

    updateGame();

    drawCars();

    drawPlayer();

    drawHUD();

    requestAnimationFrame(game);

}

game();

    }

}
