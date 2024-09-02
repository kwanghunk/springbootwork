import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function Table() {
  const [startDate, setStartDate] = useState(new Date());
  return(
    <table className='table1'>
      <tr>
        <th>날짜선택</th>
        <th>시간선택</th>
      </tr>
      <tr>
        <td>
          {/*캘린더 폼*/}
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
          {/*타임 폼*/}
          <select>
            <option>가나다라</option>
            <option>마바사아</option>
            <option>자차카타</option>
            <option></option>
            <option></option>
          </select>
        </td>
      </tr>
      <tr>
        <td colSpan='2'>
          <input type='submit' value='예약하기'></input>&emsp;
          <input type='submit' value='취소하기'></input>
        </td>
      </tr>
    </table>
  )
}

function App() {
	const [hello, setHello] = useState('')

  useEffect(() => {
    axios.get('/api/hello')
    .then(response => setHello(response.data))
    .catch(error => console.log(error))
}, []);

  return (
    <div className="App">
      <h2>예약하기</h2>
      <Table></Table>
      백엔드에서 가져온 데이터입니다 : {hello}
    </div>
  );
}

export default App;
