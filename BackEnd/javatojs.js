// Send a GET request to your Java API endpoint
fetch('http://localhost:8080/api/hello') // Replace with the actual URL of your API endpoint
  .then(response => {
    if (response.ok) {
      return response.text();
    } else {
      throw new Error('Failed to fetch data');
    }
  })
  .then(data => {
    // Process the data received from the API
    console.log(data);
  })
  .catch(error => {
    console.error(error);
  });
