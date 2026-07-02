const API_BASE = 'jetsetgospringbootproject.railway.internal/api';

async function apiGet(endpoint) {
    try {
        const response = await fetch(`${API_BASE}${endpoint}`);
        return await response.json();
    } catch (err) {
        console.error('GET error:', err);
        return null;
    }
}

async function apiPost(endpoint, data) {
    try {
        const response = await fetch(`${API_BASE}${endpoint}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });
        return await response.json();
    } catch (err) {
        console.error('POST error:', err);
        return { status: 'error', message: 'Network error. Is the server running?' };
    }
}

async function apiMultipart(endpoint, formData) {
    try {
        const response = await fetch(`${API_BASE}${endpoint}`, {
            method: 'POST',
            body: formData
        });
        return await response.json();
    } catch (err) {
        console.error('Multipart POST error:', err);
        return { status: 'error', message: 'Network error. Is the server running?' };
    }
}
