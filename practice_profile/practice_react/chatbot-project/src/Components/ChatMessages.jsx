import {useEffect, useRef} from "react";
import {ChatMessage} from "./ChatMessage.jsx";
import './ChatMessage.css';

export function ChatMessages({chatMessages}){

    // FIX: Added chatMessages as a prop
    const chatMessagesRef =  useRef(null);
    useEffect(()=>{
        const containerElem= chatMessagesRef.current
        if(containerElem){
            containerElem.scrollTop = containerElem.scrollHeight;
        }
    }, [chatMessages]);
    return(
        <div className="chat-messages-container" ref={chatMessagesRef}>

            {chatMessages.map((chatMessage) => {
                return (
                    <ChatMessage
                        key={chatMessage.id}
                        message={chatMessage.message}
                        sender={chatMessage.sender}
                    />
                )
            })}
        </div>
    );
}

