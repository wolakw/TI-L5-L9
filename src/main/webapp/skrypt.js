const miesiace = ['stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia',  'września', 'października', 'listopada', 'grudnia' ];

function funkcje() {
    let news1 = document.getElementById("news1");
    let news2 = document.getElementById("news2");
    news1.innerHTML = powitanie()+"<br/>"+data()+"<br/>";
    news2.innerHTML = dniDoUrodzin();
}

function powitanie() {
    let dzisiaj = new Date();
    let godzina = dzisiaj.getHours();
    if( (godzina<18) && (godzina>6) ) {
        return 'Dzień dobry,';
    } else {
        return 'Dobry wieczór,';
    }
}

function data() {
    let dzisiaj = new Date();
    let dzien =  dzisiaj.getDate();
    let miesiac = miesiace[dzisiaj.getMonth()];
    let rok = dzisiaj.getFullYear();

    return 'dzisiaj jest '+ dzien + ' ' +  miesiac + ' ' + ' '  + rok + ' r.';
}

function dniDoUrodzin() {
    let urodzinyDzien = 20;
    let urodzinyMiesiac = 11;

    let urodziny = new Date(2023,urodzinyMiesiac - 1,urodzinyDzien);
    let dzisiaj = new Date();

    let wynik = Math.floor((urodziny - dzisiaj) / (1000*60*60*24)); // roznica w millisekundach

    return 'Autor będzie mieć urodziny za ' + wynik + ' dni.';
}

function zegarek() {
    let data = new Date();
    let godzina = data.getHours();
    let minuta = data.getMinutes();
    let sekunda = data.getSeconds();

    if (minuta<10) minuta="0"+minuta;
    if (sekunda<10) sekunda="0"+sekunda;
    let stopka = document.getElementById("stopka");
    stopka.innerHTML="&copy;2023 WW | "+godzina+":"+minuta+":"+sekunda;
}