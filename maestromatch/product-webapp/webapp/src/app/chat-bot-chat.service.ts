import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders,HttpResponse, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ChatBotChatService {

  private apiUrl = 'http://localhost:7070/content/chatbot/ask'; // Update with your backend URL

  constructor(private http: HttpClient) {}

  

  askQuestion(prompt: string): Observable<string> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    // Set responseType to 'text' to indicate that you expect plain text response
    let params = new HttpParams();
    params = params.set('prompt', prompt.concat(" constrain upto 50 words"));

   
    //   const url=`http://localhost:8080/chatbot/ask?prompt=${prompt}`;
    //   return this.http.get<any>(url);
    // }

    return this.http
      .get(this.apiUrl, {
        headers,
        params,
        responseType: 'arraybuffer' ,// Cast responseType
        observe: 'response'  // Cast observe
      })
      .pipe(
          map((response) => {
            const arrayBuffer = response.body as ArrayBuffer;
            if (arrayBuffer) {
              const textDecoder = new TextDecoder('utf-8');
              return textDecoder.decode(arrayBuffer);
            } else {
              // Handle the case where the response body is null or undefined
              return '';
            }
        })
      )
}
  }
