import {useState} from "react";
import './ChatInpurt.css'

export function ChatInput({chatMessages, setChatMessages}){

    const [inputText , setInputText] = useState('');

    function SaveInputText(event){
        setInputText(event.target.value);
    }

    function sendMessage(){
        // FIX: Added check to prevent sending empty messages
        if (inputText.trim() === '') return;

        setChatMessages([...chatMessages, {
            message: inputText,
            sender: 'user',
            id: crypto.randomUUID()
        }]);

        // FIX: Clear input after sending message
        setInputText('');
    }

    return (
        <div className={"chat-input-container"}>
            <input
                placeholder="Send a message to the bot"
                size="50"
                onChange={SaveInputText}
                value={inputText}
                className= "chat-input"
            />
            <button onClick={sendMessage} className="send-button">Send</button>
        </div>
    );
}
