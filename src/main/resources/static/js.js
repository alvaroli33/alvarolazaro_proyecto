window.onload=function(){
    leeViajes();
    var cadenaHTML="";
	async function leeViajes(){
        const response =await fetch('/viajes');
        const viajes =await response.json();
        procesaViajes(viajes);
	}
        function procesaViajes(viajes){
            for (viaje of viajes){
                cadenaHTML+=`        
                    <h4 class="${viaje.idviajes}">${viaje.coche}</h4>
                `;
            }
        document.body.innerHTML=cadenaHTML;
        }
    
}