import React from 'react';
import Table from '../../component/table/Table';
import TableColumn from '../../component/table/TableColumn';
import TableRow from '../../component/table/TableRow';
import ReactPaginate from "react-paginate"; 

const PostList = props => {
  return (
    <>
      <Table headersName={['제목', '등록일']}>
        <TableRow>
          <TableColumn>첫번째 게시글입니다.</TableColumn>
          <TableColumn>2020-10-25</TableColumn>
        </TableRow>
        <TableRow>
          <TableColumn>두번째 게시글입니다.</TableColumn>
          <TableColumn>2020-10-25</TableColumn>
        </TableRow>
        <TableRow>
          <TableColumn>세번째 게시글입니다.</TableColumn>
          <TableColumn>2020-10-25</TableColumn>
        </TableRow>
        <TableRow>
          <TableColumn>네번째 게시글입니다.</TableColumn>
          <TableColumn>2020-10-25</TableColumn>
        </TableRow>
        <TableRow>
          <TableColumn>다섯번째 게시글입니다.</TableColumn>
          <TableColumn>2020-10-25</TableColumn>
        </TableRow>
      </Table>
      <ReactPaginate 
        pageCount={Math.ceil(100 / 5)} // totalRecords
        pageRangeDisplayed={5}
        marginPagesDisplayed={0}
        breakLabel={""}
        previousLabel={"<"}
        nextLabel={">"}
        //onPageChange={changePage}
        containerClassName={"pagination-ul"}
        activeClassName={"currentPage"}
        previousClassName={"pageLabel-btn"}
        nextClassName={"pageLabel-btn"}
      />  
    </>
  )
}
 
export default PostList;