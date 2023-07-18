
const especialidadSelect = document.getElementById("especialidad");
function getCitasMedicas() {
    fetch("/api/citasmedicas")
        .then(response => response.json())
        .then(data => {
            const citasMedicasTable = document.getElementById("citasMedicasTable");
            citasMedicasTable.innerHTML = "";
            const especialidadSelect = document.getElementById("especialidad");
            especialidadSelect.innerHTML = "";
            const option = document.createElement("option");
            option.value = "";
            option.text = ".......................";
            especialidadSelect.appendChild(option);
            data.especialidades.forEach(especialidad => {
                const option = document.createElement("option");
                option.value = especialidad.id_especialidad;
                option.text = especialidad.nombre_especialidad;
                especialidadSelect.appendChild(option);
            });
            data.citasMedicas.forEach(citaMedica => {
                const row = document.createElement("tr");
                const fechaFormatted = formatDate(new Date(citaMedica.fecha));
                const pacienteNombreCompleto = citaMedica.paciente ? `${citaMedica.paciente.nombre} ${citaMedica.paciente.apellido}` : 'Sin paciente asignado';
                const rowClass = citaMedica.disponibilidad ? 'table-success' : 'table-danger';
                row.classList.add(rowClass);
                row.innerHTML = `
                    <td>${citaMedica.id_cita}</td>
                    <td>${citaMedica.especialidad.nombre_especialidad}</td>
                    <td>${citaMedica.doctor.nombre} ${citaMedica.doctor.apellido}</td>
                    <td>${fechaFormatted}</td>
                    <td>${pacienteNombreCompleto}</td>
                    <td>${citaMedica.disponibilidad ? "Disponible" : 'No Disponible'}</td>
                `;
                citasMedicasTable.appendChild(row);
            });
        })
        .catch(error => console.log("Error al obtener las citas médicas:", error));
}

crearForm.addEventListener("submit", (event) => {
    event.preventDefault();
    const especialidad = document.getElementById("especialidad").value;
    const doctor = document.getElementById("doctor").value;
    const fecha = document.getElementById("fecha").value;
    let numero_cedula = document.getElementById("numero_cedula").value;

    if (especialidad.trim() === '' || doctor.trim() === '' || fecha.trim() === '') {
        window.alert('Todos los campos son requeridos menos cedula');
        return;
    }

    if (numero_cedula.length > 10 || isNaN(numero_cedula)) {
        window.alert('El número de cédula debe tener maximo 10 caracteres y ser numérico');
        return;
    }
    if(numero_cedula==""){
        numero_cedula=null;
    }
    const fecha_n = new Date(fecha);
    fecha_n.setDate(fecha_n.getDate() + 1);
    const nuevaFecha = fecha_n.toISOString().split("T")[0];
    const citaMedica = {
        numero_cedula: numero_cedula,
        id_especialidad: especialidad,
        id_doctor: doctor,
        fecha: nuevaFecha
    };
    console.log(citaMedica)
    fetch("/api/citasmedicas", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(citaMedica)
    })
        .then(response => response.json())
        .then(data => {
            crearForm.reset();
            getCitasMedicas();
        })
        .catch(error => Errores(error));
});

function Errores (error){
    window.alert("Error"+error);
    crearForm.reset();
    getCitasMedicas();
}
function cargarEspecialidadesYDoctores(especia) {
    fetch(`/api/citasmedicas/crear/${especia}`)
        .then(response => response.json())
        .then(data => {
            var especialidades = data.especialidades;
            var doctores = data.doctores;
            if (especialidades && Array.isArray(especialidades)) {
                var doctorSelect = document.getElementById("doctor");
                doctorSelect.innerHTML = "";
                var option = document.createElement("option");
                option.value = "";
                option.text = ".........................";
                doctorSelect.appendChild(option);
                var especialidadSelect = document.getElementById("especialidad");
                especialidadSelect.innerHTML = "";
                var option = document.createElement("option");
                option.value = "";
                option.text = ".........................";
                especialidadSelect.appendChild(option);
                especialidades.forEach(especialidad => {
                    var option = document.createElement("option");
                    option.value = especialidad.id_especialidad;
                    option.text = especialidad.nombre_especialidad;
                    especialidadSelect.appendChild(option);
                });
            }

            if (doctores && Array.isArray(doctores)) {
                var doctorSelect = document.getElementById("doctor");
                doctorSelect.innerHTML = "";
                var option = document.createElement("option");
                option.value = "";
                option.text = ".........................";
                doctorSelect.appendChild(option);
                doctores.forEach(doctor => {
                    var option = document.createElement("option");
                    option.value = doctor.id_doctor;
                    option.text = doctor.nombre + " " + doctor.apellido;
                    doctorSelect.appendChild(option);
                });
            }
        })
        .catch(error => console.log("Error al cargar especialidades y doctores:", error));
}


especialidadSelect.addEventListener("change", () => {
    const especia = especialidadSelect.value;
    if(especia!="")cargarEspecialidadesYDoctores(especia);
    else cargarEspecialidadesYDoctores("n");
});
function formatDate(date) {
    const options = { weekday: 'long', day: 'numeric', month: 'long', year: 'numeric' };
    return date.toLocaleDateString('es-ES', options);
}
window.addEventListener("DOMContentLoaded", getCitasMedicas);
