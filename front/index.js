document.getElementById('registrar').addEventListener('click', () => {
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;

    // Verifique se os valores dos inputs estão sendo capturados corretamente
    console.log('Título:', titulo);
    console.log('Autor:', autor);

    if (!titulo || !autor) {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    fetch('http://localhost:8080/livros/adicionar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ titulo, autor })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro na requisição: ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log('Resposta do servidor:', data);
        alert('Livro registrado com sucesso!');
    })
    .catch(error => {
        console.error('Erro ao registrar o livro:', error);
        alert('Erro ao registrar o livro: ' + error.message);
    });
});

document.getElementById('verCatalogo').addEventListener('click', () => {
    window.location.href = 'catalogo.html';
});