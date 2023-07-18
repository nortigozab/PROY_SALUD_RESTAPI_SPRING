
const crearForm = document.getElementById("crearForm");
const cedulaInput = document.getElementById("cedula");
const cedulaError = document.getElementById("cedulaError");
const telefonoInput = document.getElementById("telefono");
const telefonoError = document.getElementById("telefonoError");

crearForm.addEventListener("submit", (event) => {
    event.preventDefault();

    if (!validarCedula()) {
        return;
    }

    if (!validarTelefono()) {
        return;
    }
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const cedula = cedulaInput.value;
    const fechaNacimiento = document.getElementById("fechaNacimiento").value;

    const fecha = new Date(fechaNacimiento);

    fecha.setDate(fecha.getDate() + 1);

    const nuevaFechaNacimiento = fecha.toISOString().split("T")[0];

    const telefono = telefonoInput.value;
    const paciente = {
        nombre: nombre,
        apellido: apellido,
        numero_cedula: cedula,
        fecha_nacimiento: nuevaFechaNacimiento,
        telefono: telefono
    };
    fetch("/api/pacientes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(paciente)
    })
        .then(response => response.json())
        .then(nuevoPaciente => {
            crearForm.reset();
            obtenerPacientes();
        })
        .catch(error => console.error("Error:", error));
});
function obtenerPacientes() {
    const pacientesTable = document.getElementById("pacientesTable");
    pacientesTable.innerHTML = "";
    fetch("/api/pacientes")
        .then(response => response.json())
        .then(pacientes => {
            pacientes.forEach(paciente => {
                const row = document.createElement("tr");
                const edad = calcularEdad(paciente.fecha_nacimiento);
                const edadFormateada = `${edad.anos} años, ${edad.meses} meses, ${edad.dias} días`;
                row.innerHTML = `
            <td>${paciente.id_paciente}</td>
            <td>${paciente.nombre}</td>
            <td>${paciente.apellido}</td>
            <td>${paciente.numero_cedula}</td>
            <td>${edadFormateada}</td>
            <td>${paciente.telefono}</td>
            <td>
              <button onclick="editarPaciente('${paciente.id_paciente}')" class="btn btn-warning">Editar</button>
              <button onclick="eliminarPaciente('${paciente.id_paciente}')" class="btn btn-danger">Eliminar</button>
            </td>
          `;
                pacientesTable.appendChild(row);
            });
        })
        .catch(error => console.error("Error:", error));
}
function editarPaciente(id_paciente) {
    fetch(`/api/pacientes/${id_paciente}`)
        .then(response => response.json())
        .then(paciente => {
            document.getElementById("nombre").value = paciente.nombre;
            document.getElementById("apellido").value = paciente.apellido;
            document.getElementById("cedula").value = paciente.numero_cedula;
            const fechaObj = new Date(paciente.fecha_nacimiento);
            const fechaFormateada = fechaObj.toISOString().split("T")[0];
            document.getElementById("fechaNacimiento").value = fechaFormateada;
            document.getElementById("telefono").value = paciente.telefono;
            crearForm.removeEventListener("submit", (event) => { event.preventDefault(); });
            crearForm.addEventListener("submit", (event) => {
                event.preventDefault(); // Evitar que el formulario se envíe por defecto
                if (!validarCedula()) {
                    return;
                }

                if (!validarTelefono()) {
                    return;
                }
                paciente.nombre = document.getElementById("nombre").value;
                paciente.apellido = document.getElementById("apellido").value;
                paciente.numero_cedula = document.getElementById("cedula").value;
                paciente.fecha_nacimiento = document.getElementById("fechaNacimiento").value;
                paciente.telefono = document.getElementById("telefono").value;
                fetch(`/api/pacientes/${id_paciente}`, {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(paciente)
                })
                    .then(response => response.json())
                    .then(pacienteActualizado => {
                        crearForm.reset();
                        obtenerPacientes();
                    })
                    .catch(error => console.error("Error:", error));
            });
        })
        .catch(error => console.error("Error:", error));
}

function eliminarPaciente(id_paciente) {
    if (confirm(`¿Estás seguro de eliminar este al paciente ${id_paciente}?`)) {
        fetch(`/api/pacientes/${id_paciente}`, {
            method: "DELETE"
        })
            .then(response => response.json())
            .then(response => {
                if (response.Eliminado) {
                    obtenerPacientes();
                }
            })
            .catch(error => console.error("Error:", error));
    }

}
function validarCedula() {
    const cedula = cedulaInput.value.trim();

    if (cedula.length > 10 || isNaN(cedula)) {
        cedulaInput.classList.add("is-invalid");
        cedulaError.textContent = "La cédula debe contener máximo 10 dígitos numéricos.";
        return false;
    }

    cedulaInput.classList.remove("is-invalid");
    cedulaError.textContent = "";
    return true;
}
function validarTelefono() {
    const telefono = telefonoInput.value.trim();

    if (telefono.length !== 10 || isNaN(telefono)) {
        telefonoInput.classList.add("is-invalid");
        telefonoError.textContent = "El teléfono debe contener 10 dígitos numéricos.";
        return false;
    }

    telefonoInput.classList.remove("is-invalid");
    telefonoError.textContent = "";
    return true;
}
obtenerPacientes();
function calcularEdad(fechaNacimiento) {
    const hoy = new Date();
    const fechaNac = new Date(fechaNacimiento);
    let edad = {
        anos: 0,
        meses: 0,
        dias: 0
    };
    let anos = hoy.getFullYear() - fechaNac.getFullYear();
    let meses = hoy.getMonth() - fechaNac.getMonth();
    let dias = hoy.getDate() - fechaNac.getDate();

    if (meses < 0 || (meses === 0 && dias < 0)) {
        anos--;
        meses += 12;
    }

    if (dias < 0) {
        const ultimoDiaMesAnterior = new Date(hoy.getFullYear(), hoy.getMonth(), 0).getDate();
        dias += ultimoDiaMesAnterior;
        meses--;
    }

    edad.anos = anos;
    edad.meses = meses;
    edad.dias = dias;

    return edad;
}