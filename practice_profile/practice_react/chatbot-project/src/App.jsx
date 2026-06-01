import { useState } from 'react'

import {ChatInput} from "./Components/ChatInput.jsx";

import {ChatMessages} from "./Components/ChatMessages.jsx";
import './App.css'












function App() {
    const [chatMessages, setChatMessages] = useState([
        {
            message: 'hello chatbot',
            sender: 'user',
            id: 'id1'
        },
        {
            message: 'hello how can i help you',
            sender: 'robot',
            id: 'id2'
        },
        {
            message: 'can you get me today\'s date?',
            sender: 'user',
            id: 'id3'
        },
        {
            message: 'today is 21 of may',
            sender: 'robot',
            id: 'id4'
        }
    ]);

    return (
        <div className="app-container">

            <ChatMessages chatMessages={chatMessages} /> {/* FIX: Pass chatMessages as prop */}
            <ChatInput
                chatMessages={chatMessages}
                setChatMessages={setChatMessages}
            />
        </div>
    );
}

export default App
