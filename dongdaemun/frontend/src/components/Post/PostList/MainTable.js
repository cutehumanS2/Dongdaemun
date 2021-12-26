import React, {useState, useEffect} from 'react';
import Pagination from './Pagination';
import { paginate } from './paginate';

const MainTable = () => {
  const getMovies = () => {
    const movies = [
      {
        "createDate": "2021-12-20T20:26:31.495907", //LocalDateTime
        "modifieDate": "2021-12-20T20:26:31.495907", //LocalDateTime
        "id": 2, //Long
        "uid": "minpearl0826@gmail.com", //String
        "title": "공지1", //String
        "content": "<p>ㅇ</p>", //String
        "anony": false //boolean
    },
    {
        "createDate": "2021-12-20T19:52:31.305561",
        "modifieDate": "2021-12-20T19:52:31.305561",
        "id": 1,
        "uid": "",
        "title": "공지1",
        "content": "<p>ㅇㄹㄴ</p>",
        "anony": false
    }
    ]
    return movies;
  }

  const [movies, setMovies] = useState({ // 영화 정보를 담는 state
    data: getMovies(), // 영화 정보
    pageSize: 8, // 한 페이지에 보여줄 아이템(영화목록) 개수
    currentPage: 1 // 현재 활성화된 페이지 위치
  });

  const handlePageChange = (page) => {
    setMovies({ ...movies, currentPage: page });
  };

  const { data, pageSize, currentPage } = movies;
  const pagedMovies = paginate(data, currentPage, pageSize); // 페이지 별로 아이템이 속한 배열을 얻어옴

  const { length: count } = movies.data;
  if (count === 0) 
    return <p>게시글이 없습니다.</p>;

  return (
    <>
      <p className='title'>공지 게시판</p>
      <div className="tablediv">
      <table className="table">
        <thead className="thead">
          <tr>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody className="maintbody">
          {pagedMovies.map((movie) => (
            <tr key={movie.id}>
              <td>{movie.title}  {movie.content}</td>
              <td>{movie.createDate}  {movie.uid}</td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
      <Pagination
        pageSize={pageSize}
        itemsCount={count}
        currentPage={currentPage}
        onPageChange={handlePageChange}
      />
    </>
  );
};

export default MainTable;