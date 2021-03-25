//
//  GridView.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 19/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct GridView<ContentView: View>: View {
    
    let rows: Int
    let columns: Int
    let content: (Int, Int) -> ContentView
    
    init(rows: Int, columns: Int, @ViewBuilder content: @escaping (Int, Int) -> ContentView) {
        self.rows = rows
        self.columns = columns
        self.content = content
    }
    
    var body: some View {
        VStack {
            ForEach(0..<rows, id: \.self) { row in
                HStack {
                    ForEach(0..<columns, id: \.self) { column in
                        content(row, column)
                    }
                }
            }
        }
    }
}
