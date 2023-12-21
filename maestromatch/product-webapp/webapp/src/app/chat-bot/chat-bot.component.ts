import { Component, ChangeDetectorRef } from '@angular/core';
import { ChatBotChatService } from '../chat-bot-chat.service';
import { delay } from 'rxjs';


@Component({
  selector: 'app-chat-bot',
  templateUrl: './chat-bot.component.html',
  styleUrls: ['./chat-bot.component.css']
})
export class ChatBotComponent {
  message = '';
  responseMessage = '';
  messages: string[]=[];
  responseMessages: string[]=[];
  you='You : ';
  bot='Bot : ';

  constructor(private chatBotChatService:ChatBotChatService, private cdRef: ChangeDetectorRef){}

  ngOnInit() {
    // Initialize the chat with a welcome message or any initial messages
    
    this.responseMessages.push('Bot : Welcome to the chat!');
  }

   

  sendMessage() {
    if (this.message.trim() === '') return;

    this.chatBotChatService.askQuestion(this.message).subscribe(
      (response:any) => {
        this.messages.push(this.you.concat(this.message));
        this.responseMessage = response;
        this.responseMessages.push(this.bot.concat(this.responseMessage));
        // You can add logic to handle the response here
      },
      (error) => {
        console.error('Error sending message:', error);
      }
    );
  }
  reset(){
    this.message = '';
  }

  chatboxOpen: boolean = false;

  toggleChatbox() {
    console.log("please close!")
    this.chatboxOpen = !this.chatboxOpen;
  }
}
