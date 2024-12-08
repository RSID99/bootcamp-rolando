function descargarPDF() {
    const element = document.getElementById("curr");
    const opt = {
        margin: 1,
        filename: 'CV_Rolando_Insfran.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 1.5, useCORS: true ,scrollY:0},
        jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
    };

    html2pdf().set(opt).from(element).save().then(() => {
        console.log("PDF generado con éxito.");
    }).catch(err => {
        console.error("Error al generar el PDF:", err);
    });
}
function atras(){
        window.location.href = "inicio.html";
}

function enviar() {
    const comentarios = document.getElementById("comentarios").value;
    alert("Comentarios enviados: " + comentarios);
    console.log("Mensaje de Contacto: ", comentarios);
    document.getElementById("comentarios").value = "";
}