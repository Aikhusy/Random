local MarketplaceService = game:GetService('MarketplaceService')

local Assets = {
 -- array untuk menampung asset dari baju yang kalian inginkan
}

local TotalSales = 0

for _, id in ipairs(Assets) do
    local Info = MarketplaceService:GetProductInfo(id, Enum.InfoType.Asset)
    TotalSales += tonumber(Info.Sales)
end

--bisa pake code lanjutan untuk memb
print(TotalSales)