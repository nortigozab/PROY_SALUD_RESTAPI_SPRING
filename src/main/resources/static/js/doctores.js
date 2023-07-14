crearForm.addEventListener("submit", (event) => {
    event.preventDefault(); // Evitar que el formulario se envíe por defecto

    // Obtener los valores de los campos del formulario
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const consultorio = document.getElementById("consultorio").value;
    const especialidad = document.getElementById("especialidad").value;
    const correo = document.getElementById("correo").value;

    // Validar que ningún campo esté vacío
    if (!nombre || !apellido || !consultorio || !especialidad || !correo) {
        window.alert("Por favor, complete todos los campos.");
        return; // Detener la ejecución del código si algún campo está vacío
    }

    // Expresión regular para validar que el campo "consultorio" contenga solo números
    const numberRegex = /^[0-9]+$/;

    // Validar que el campo "consultorio" contenga solo números
    if (!numberRegex.test(consultorio)) {
        window.alert("El campo 'consultorio' debe contener solo números.");
        return; // Detener la ejecución del código si el campo "consultorio" no contiene solo números
    }

    // Expresión regular para validar el formato de correo electrónico
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // Validar que el correo tenga un formato válido
    if (!emailRegex.test(correo)) {
        window.alert("Por favor, ingrese un correo electrónico válido.");
        return; // Detener la ejecución del código si el correo no tiene un formato válido
    }

    // Crear el objeto de doctor con los datos del formulario
    const doctor = {
        nombre: nombre,
        apellido: apellido,
        consultorio: consultorio,
        especialidad: especialidad,
        correo_contacto: correo
    };

    // Realizar una solicitud POST para guardar el doctor
    fetch("/api/doctores", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(doctor)
    })
        .then(response => response.json())
        .then(nuevoDoctor => {
            // Limpiar el formulario y actualizar la lista de doctores
            crearForm.reset();
            getDoctores();
        })
        .catch(error => console.log("Error al crear el doctor:", error));
});

// Función para obtener la lista de doctores
function getDoctores() {
    fetch("/api/doctores")
        .then(response => response.json())
        .then(data => {
            // Limpiar la tabla de doctores
            const doctoresTable = document.getElementById("doctoresTable");
            doctoresTable.innerHTML = "";

            // Llenar el select de especialidades
            const especialidadSelect = document.getElementById("especialidad");
            especialidadSelect.innerHTML = "";
            const defaultOption = document.createElement("option");
            defaultOption.value = "";
            defaultOption.textContent = "..............";
            especialidadSelect.appendChild(defaultOption);
            data.especialidades.forEach(especialidad => {
                const option = document.createElement("option");
                option.value = especialidad.id_especialidad;
                option.textContent = especialidad.nombre_especialidad;
                especialidadSelect.appendChild(option);
            });

            // Iterar sobre los doctores y agregarlos a la tabla
            data.doctores.forEach(doctor => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${doctor.id_doctor}</td>
                    <td>${doctor.nombre}</td>
                    <td>${doctor.apellido}</td>
                    <td>${doctor.consultorio}</td>
                    <td>${doctor.especialidad.nombre_especialidad}</td>
                    <td>${doctor.correo_contacto}</td>
                    <td>
                        
                        <button class="btn btn-sm btn-danger" onclick="eliminarDoctor(${doctor.id_doctor})">Eliminar</button>
                    </td>
                `;
                doctoresTable.appendChild(row);
            });
        })
        .catch(error => console.log("Error al obtener los doctores:", error));
}
// Función para eliminar un doctor
function eliminarDoctor(id_doctor) {
    if (confirm(`¿Estás seguro de eliminar este al doctor ${id_doctor}?`)) {
        fetch(`/api/doctores/${id_doctor}`, {
            method: "DELETE"
        })
            .then(response => {
                // Actualizar la lista de doctores
                getDoctores();
            })
            .catch(error => console.log("Error al eliminar el doctor:", error));
    }
}

// Cargar la lista de doctores al cargar la página
window.addEventListener("DOMContentLoaded", getDoctores);
