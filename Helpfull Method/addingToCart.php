<?php
function addToCart(Request $request, $id)
    {
        $jsonString = $request->cookie('cart');
        $validated['id'] = $id;

        if ($jsonString !== null) {
            $data = json_decode($jsonString, true);

            if ((is_array($data) && isset($data['id']))) {
                $dataArray = [
                    'id' => [$data['id']], // Menempatkan elemen dalam array
                ];
                foreach ($dataArray['id'] as $value) {

                    if ($value == $validated['id']) {
                        // Nilai $validated['id'] sudah ada dalam cookie 'cart'
                        // Lakukan tindakan yang sesuai
                        return redirect()->route('produk.display'); // Keluar dari perulangan jika nilai sudah ditemukan
                    }
                }
                $dataTambahan = $validated;
                $mergedData = array_merge_recursive($data, $dataTambahan);
                $dataReady = json_encode($mergedData);

                // Lakukan sesuatu dengan $data jika cookie 'cart' ada
                // ...

                Cookie::queue('cart', $dataReady, 60);
            }
        } else {
            $cookieValue = json_encode($validated);
            Cookie::queue('cart', $cookieValue, 60 * 60);
        }
        $Produknya=Product::find($validated['id']);
        return redirect()->route('produk.display')->with('success', 'berhasil memasukkan ' .$Produknya->nama_produk .' ke keranjang');
    }

    public function showCookie(Request $request)
    {
        $cookieValue = Cookie::get('cart');
        $data = [];
        $data = json_decode($cookieValue, true);
        $produk = [];
        $active = "cart";
        if (isset($data)) {
            if (is_array($data['id'])) {
                foreach ($data['id'] as $value) {
                    $produkBaru = Product::where('id', $value)->first();
                    if ($produkBaru) {
                        $produk[] = $produkBaru;
                    }
                }
            } else {
                $produkBaru = Product::where('id', $data['id'])->first();
                $produk[] = $produkBaru;
                return view('cart.tableCart', compact('produk'))->with('active', $active);
            }
        }

        return view('cart.tableCart', compact('produk'))->with('active', $active);
    }
?>