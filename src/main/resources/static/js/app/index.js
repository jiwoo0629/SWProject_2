var main = {
    init : function() {
        var _this = this;
        $('#btn-write').on('click', function () {
            _this.write();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },

    write : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: "/board/write",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done( function() {
            if(data.title == "" || data.content == "")
                alert('내용 부족, 이전 페이지로 이동');
            else
                alert('등록 완료');
            window.location.href = '/';
        }).fail( function(error) {
            alert(JSON.stringify(error));
        });
    },

    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: "/board/modify/"+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            if(data.title == "" || data.content == "")
            {
                alert('내용 부족, 이전 페이지로 이동');
                window.location.href = '/board/view/'+id;
            }
            else {
                alert('수정 완료');
                window.location.href = '/'
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: "/api/v1/post/"+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(id)
        }).done(function(){
            alert('삭제 완료');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

main.init();