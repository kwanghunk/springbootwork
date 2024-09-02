import React, { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function App() {
	const [startDate, setStartDate] = useState(new Date());
  return (
    <div className="App">
    
      <table>
      	<tr>
      		<th>날짜선택</th>
      		<th>시간선택</th>
      	</tr>
      	<tr>
      		<td>
      			/*캘린더 폼*/
      			<DatePicker
		            selected={startDate}
		            onChange={(date) => setStartDate(date)}
		            locale="pt-BR"
		            showTimeSelect
		            timeFormat="p"
		            timeIntervals={15}
		            dateFormat="Pp"
          		/>
      		</td>
      		<td>
      			/*타임 폼*/
      			<select>
      				<option></option>
      				<option></option>
      				<option></option>
      				<option></option>
      				<option></option>
      			</select>
      		</td>
      	</tr>
      </table>
    </div>
  );
}

export default App;
