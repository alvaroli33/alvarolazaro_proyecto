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
                 	<article>
                 		<div class="info">
                 		<span><strong>Origen: </strong>${viaje.origen.nombre}</span>
                 		<span><strong>Destino: </strong>${viaje.destino.nombre}</span>
                 		<span><strong>Asientos disponibles: </strong>${viaje.asientos}</span>
                 		<span><strong>Horario de Salida: </strong>${viaje.horasalida}</span>
                 		<span><strong>Horario de Llegada: </strong>${viaje.horallegada}</span>
                 		</div>
                 		<span>${viaje.usuario.username}</span>
                 	</article>
                `;
    }
    publicacion.innerHTML=cadenaHTML;
    }
    
}