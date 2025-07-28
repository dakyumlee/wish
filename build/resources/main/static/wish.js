async function submitWish() {
  const wish = document.getElementById("wishInput").value
  const chatBox = document.getElementById("chatBox")

  chatBox.innerHTML += `
    <div class="chat user">
      <div class="bubble">${wish}</div>
    </div>
  `

  const response = await fetch("/api/wish", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ wish })
  })

  const data = await response.json()

  chatBox.innerHTML += `
    <div class="chat bot">
      <div class="bubble">${data.response}</div>
    </div>
  `

  document.getElementById("wishInput").value = ""
  chatBox.scrollTop = chatBox.scrollHeight
}
