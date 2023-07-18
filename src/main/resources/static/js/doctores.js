crearForm.addEventListener("submit", (event) => {
    event.preventDefault();
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const consultorio = document.getElementById("consultorio").value;
    const especialidad = document.getElementById("especialidad").value;
    const correo = document.getElementById("correo").value;
    if (!nombre || !apellido || !consultorio || !especialidad || !correo) {
        window.alert("Por favor, complete todos los campos.");
        return;
    }
    const numberRegex = /^[0-9]+$/;

    if (!numberRegex.test(consultorio)) {
        window.alert("El campo 'consultorio' debe contener solo números.");
        return;
    }
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(correo)) {
        window.alert("Por favor, ingrese un correo electrónico válido.");
        return;
    }


    const doctor = {
        nombre: nombre,
        apellido: apellido,
        consultorio: consultorio,
        especialidad: especialidad,
        correo_contacto: correo
    };
    fetch("/api/doctores", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(doctor)
    })
        .then(response => response.json())
        .then(nuevoDoctor => {
            crearForm.reset();
            getDoctores();
        })
        .catch(error => console.log("Error al crear el doctor:", error));
});
function getDoctores() {
    fetch("/api/doctores")
        .then(response => response.json())
        .then(data => {
            const doctoresTable = document.getElementById("doctoresTable");
            doctoresTable.innerHTML = "";
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
function eliminarDoctor(id_doctor) {
    if (confirm(`¿Estás seguro de eliminar este al doctor ${id_doctor}?`)) {
        fetch(`/api/doctores/${id_doctor}`, {
            method: "DELETE"
        })
            .then(response => {
                getDoctores();
            })
            .catch(error => console.log("Error al eliminar el doctor:", error));
    }
}
window.addEventListener("DOMContentLoaded", getDoctores);
