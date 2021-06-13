window.onload=function(){
    leeViajes();
    var cadenaHTML="";
    const contenedor =document.createElement("div");
    const publicacion = document.createElement("section");

    contenedor.classList.add("contenedor");
    publicacion.classList.add("publicacion");

    document.body.appendChild(contenedor);
    contenedor.appendChild(publicacion);
    
    
	async function leeViajes(){
        const response =await fetch('/viajes');
        const viajes =await response.json();
        procesaViajes(viajes);
	}
    function procesaViajes(viajes){
            for (viaje of viajes){
                cadenaHTML+=`    
                <a class="viaje" href="/viaje?idviajes=${viaje.idviajes}">
                 	<article>
                 		<div class="info">
                 		<span><strong>Origen: </strong>${viaje.origen}</span>
                 		<span><strong>Destino: </strong>${viaje.destino}</span>
                 		<span><strong>Asientos disponibles: </strong>${viaje.asientos}</span>
                 		<span><strong>Fecha: </strong>${viaje.fecha}</span>
                 		<span><strong>Horario de Salida: </strong>${viaje.horasalida}</span>
                 		<span><strong>Horario de Llegada: </strong>${viaje.horallegada}</span>
                 		<span><strong>Estado: </strong>${viaje.estado}</span>
                 		<span><strong>Usuario: </strong>${viaje.usuario.username}</span>
                 		</div>               		
                 	</article>
                 </a>
                `;
    }
    publicacion.innerHTML=cadenaHTML;
    }
    
    
}