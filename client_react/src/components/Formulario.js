import React from "react";

const Formulario = () => {
    return (
      <>
        form className= "formulario">
        <div>
            <label htmlFor="Nombre">Nombre</label>
            <input type="text" id="nombre" placeholder="Jaime Zapata" />
        </div> 
        </div>
        <><label htmlFor="Correo">Correo</label>
        <input type="text" id="correo" name="correo" placeholder="correo@correo.com" /></>
        </div>
        <button type="submit">Enviar</button>
        </form> 
        </>

    );

}

export default Formulario;