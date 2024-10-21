const API_BASE_URL = 'http://localhost:8080'; // Ajuste conforme necessário

async function fetchAPI(url, method, body = null, token = null) {
    const headers = {
        'Content-Type': 'application/json'
    };
    if (token) {
        headers['Authorization'] = `Bearer ${token}`;
    }
    const options = {
        method,
        headers,
        body: body ? JSON.stringify(body) : null
    };
    const response = await fetch(`${API_BASE_URL}${url}`, options);
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return await response.json();
}