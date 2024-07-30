document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('productForm');
    const deleteForm = document.getElementById('deleteForm');
    const messageDiv = document.getElementById('message');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const productId = document.getElementById('productId').value;
        const productName = document.getElementById('productName').value;
        const description = document.getElementById('description').value;
        const unitPrice = parseFloat(document.getElementById('unitPrice').value);
        const unitsInStocks = parseInt(document.getElementById('unitsInStocks').value, 10);
        const categoryId = parseInt(document.getElementById('categoryId').value, 10);

        const product = { productName, description, unitPrice, unitsInStocks, categoryId };
        const method = productId ? 'PUT' : 'POST';
        const url = productId
            ? `http://localhost:9090/api/v1.0/products/all/${productId}/${categoryId}`
            : `http://localhost:9090/api/v1.0/products/all/${categoryId}`;

        try {
            const response = await fetch(url, {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(product)
            });
            
            if (response.ok) {
                showMessage('Product saved successfully.');
                form.reset();
            } else {
                showMessage('Failed to save product.');
            }
        } catch (error) {
            showMessage('Error: ' + error.message);
        }
    });

    deleteForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        
        const deleteProductId = document.getElementById('deleteProductId').value;
        
        try {
            const response = await fetch(`http://localhost:9090/api/v1.0/products/all/${deleteProductId}`, {
                method: 'DELETE'
            });
            
            if (response.ok) {
                showMessage('Product deleted successfully.');
                deleteForm.reset();
            } else {
                showMessage('Failed to delete product.');
            }
        } catch (error) {
            showMessage('Error: ' + error.message);
        }
    });

    function showMessage(message) {
        messageDiv.textContent = message;
    }
});
