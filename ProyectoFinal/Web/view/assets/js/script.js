document.getElementById("boton_descargar_exe").addEventListener("click", function() {
    
    const enlaceDescarga = document.createElement("a");
    enlaceDescarga.href = "./view/assets/TareApp_installer.exe";
    enlaceDescarga.download = "TareApp_installer.exe";
    document.body.appendChild(enlaceDescarga);
    enlaceDescarga.click();
    document.body.removeChild(enlaceDescarga);
});

document.getElementById("boton_descargar_apk").addEventListener("click", function() {
    
    const enlaceDescarga = document.createElement("a");
    enlaceDescarga.href = "./view/assets/TareApp.apk";
    enlaceDescarga.download = "TareApp.apk";
    document.body.appendChild(enlaceDescarga);
    enlaceDescarga.click();
    document.body.removeChild(enlaceDescarga);
});
