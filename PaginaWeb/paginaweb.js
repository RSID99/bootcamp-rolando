((d) => {
    const $form = d.getElementById("form");
    $form.addEventListener("submit", (e) => {
        e.preventDefault();
        const formData = new FormData($form); 
        fetch($form.action, {
            method: 'POST',
            body: formData,
            headers: {
                'Accept': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Mensaje enviado con éxito!');
                $form.reset(); 
            } else {
                alert('Error al enviar el mensaje.');
            }
        })
        .catch(error => {
            alert('Error al enviar el mensaje: ' + error);
        });
    });
})(document);


function responsiveMenu(){
    var x = document.getElementById("nav");
    if (x.className===""){
        x.className = "responsive";
    } else{
        x.className = "";
    }
}