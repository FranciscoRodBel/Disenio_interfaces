document.getElementById("boton_descargar").addEventListener("click", function() {
    
    const enlaceDescarga = document.createElement("a");
    enlaceDescarga.href = "./view/assets/TareApp_installer.exe";
    enlaceDescarga.download = "TareApp_installer.exe";
    document.body.appendChild(enlaceDescarga);
    enlaceDescarga.click();
    document.body.removeChild(enlaceDescarga);
});
