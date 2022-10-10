<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タスク</label><br />
<input type="text"  id="title" value="${Task.title}" />
<br /><br />

<label for="content_msg">タスクの内容</label><br />
<input type="text" name="content" id="content_msg" value="${Task.content}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>
